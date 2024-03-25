def code
pipeline {
    agent any
    parameters {
        string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
    }
    stages {
        stage('Load') {
            steps {
                code = load "script.groovy"
            }
        }
        stage('Build package') {
            steps {
                script {
                    code.buildJar()
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                    code.buildImage(params.IMAGE_VERSION)
                }
            }
        }
        stage('Login to Docker and Push Image') {
            steps {
                script {
                    code.loginAndpush(params.IMAGE_VERSION)
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploy'
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
