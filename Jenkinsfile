pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Your build steps here
                sh 'echo "Building..."'
                sh 'make build'
            }
        }
        stage('Test') {
            steps {
                // Your test steps here
                sh 'echo "Testing..."'
                sh 'make test'
            }
        }
        stage('Deploy') {
            steps {
                // Your deployment steps here
                sh 'echo "Deploying..."'
                sh 'make deploy'
            }
        }
    }
    
    post {
        success {
            // Actions to perform when the pipeline succeeds
            echo 'Pipeline succeeded!'
        }
        failure {
            // Actions to perform when the pipeline fails
            echo 'Pipeline failed!'
        }
    }
}
