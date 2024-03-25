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
    tool(name: 'Maven')
    parameters {
        string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('build app') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    gv.buildImage(params.IMAGE_VERSION)
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    gv.deployApp(params.IMAGE_VERSION)
                }
            }
        }
    }
}
