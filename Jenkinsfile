def gv
pipeline {
    agent any
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
        stage('Build package') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                   gv. buildImage(params.IMAGE_VERSION)
                }
            }
        }
        stage('Login to Docker and Push Image') {
            steps {
                script {
                   gv.loginAndpush(params.IMAGE_VERSION)
                }
            }
        }
        stage('deploy')
        {
            step{
               script
               {
                 echo 'deploy'
               }
            }
        }
    }
    post {
        success {
            echo 'Image build and push succeeded!'
        }
        failure {
            echo 'Image build and push failed!'
        }
    }
}
