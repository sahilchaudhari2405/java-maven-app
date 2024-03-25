// def code
// pipeline {
//     agent any
//     parameters {
//         string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
//     }
//     stages {
//         stage('init') {
//             steps {
//                script
//                {
//                  code = load "script.groovy"
//                }
//             }
//         }
//         stage('Build package') {
//             steps {
//                 script {
//                     code.buildJar()
//                 }
//             }
//         }
//         stage('Build Image') {
//             steps {
//                 script {
//                     code.buildImage(params.IMAGE_VERSION)
//                 }
//             }
//         }
//         stage('Login to Docker and Push Image') {
//             steps {
//                 script {
//                     code.loginAndpush(params.IMAGE_VERSION)
//                 }
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 script {
//                     echo 'Deploy'
//                 }
//             }
//         }
//     }
//     post {
//         success {
//             echo 'Image build and push succeeded!'
//         }
//         failure {
//             echo 'Image build and push failed!'
//         }
//     }
// }
def gv
pipeline { 
    agent any
           parameters {
            choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
            booleanParam(name: 'executeTests', defaultValue: true, description: '')
           }

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                 
                    gv.buildApp()
                }

            }
        }
        stage("test") {
            when {
             
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage ("deploy") {
            steps {
                expression {
                    env.BRANCH_NAME == 'feature/jenkins-jobs'
                }
                  script {
                gv.deployApp()
                
                }
            }
          
        }
    }
}