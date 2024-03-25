// /* groovylint-disable-next-line FactoryMethodName */
// def buildJar() {
//     echo(message: 'build application ')
//     sh 'mvn package'
// }
// def buildImage(IMAGE_VERSION) {
//     echo "Building Docker image with version ${IMAGE_VERSION}"
//     sh "docker build -t sahilchaudhari2405/my-repo:${IMAGE_VERSION} ."
// }
// def loginAndpush(IMAGE_VERSION) {
//     echo 'Logging in to Docker'
    
// }And here's the script.groovy file:

 

def buildApp() {
    echo "building the application..."
    sh 'mvn package'
} 
def buildImage(IMAGE_VERSION) {
    echo "build image"
    sh "docker build -t sahilchaudhari2405/my-repo:${IMAGE_VERSION} ."
    }
def deployApp(IMAGE_VERSION) {
    echo "deploying the ${IMAGE_VERSION}"
    withCredentials([usernamePassword(credentialsId: 'docker-repo', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
        sh "docker push sahilchaudhari2405/my-repo:${IMAGE_VERSION}"
    }
} 
return this
