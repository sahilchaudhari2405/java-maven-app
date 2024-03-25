def gv

pipeline {
    agent any
    parameters {
        string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
    }
    stages {
        // stage('init') {
        //     steps {
        //         script {
        //             gv = load 'script.groovy'
        //         }
        //     }
        // }
        stage('Build package') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                    buildImage(params.IMAGE_VERSION)
                }
            }
        }
        stage('Login to Docker and Push Image') {
            steps {
                script {
                    loginAndpush(params.IMAGE_VERSION)
                }
            }
        }
        stage('deploy') {
            steps {
                script {
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
