def buildApp() {
    echo "building the application..."
    sh 'mvn package'
} 
def buildImage(IMAGE_VERSION) {
    echo "build image"
    sh "docker build -t sahilchaudhari2405/java-mevan-app:${IMAGE_VERSION} ."
    }
def deployApp(IMAGE_VERSION) {
    echo "deploying the ${IMAGE_VERSION}"
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD} 159.89.174.141:8083"
        sh "docker push 159.89.174.141:8083/java-mevan-app:${IMAGE_VERSION}"
    }
} 
return this
