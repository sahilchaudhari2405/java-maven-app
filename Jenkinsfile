pipeline {
    agent any
    
    stages {
        stage('Build Jar') {
            steps {
                script {
                    echo 'Building application jar...'
                    buildJar()
                }
            }
        }
        
        stage('Build Docker Image') {
            parameters {
                string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
            }
            steps {
                script {
                    echo "Building Docker image with version ${params.IMAGE_VERSION}..."
                    buildImage(params.IMAGE_VERSION)
                }
            }
        }
        
        stage('Push Docker Image') {
            parameters {
                string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
            }
            steps {
                script {
                    echo "Pushing Docker image with version ${params.IMAGE_VERSION}..."
                    loginAndpush(params.IMAGE_VERSION)
                }
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
