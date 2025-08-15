pipeline {
    agent {
        docker {
            image 'maven:3.9.11-amazoncorretto-21' // Use official Maven image with JDK
            args '-v $HOME/.m2:/root/.m2' // Cache Maven dependencies
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                junit '**/target/surefire-reports/*.xml' // Archive test results
            }
        }
        // Add more stages as needed (package, deploy, etc.)
    }
    post {
        always {
            // Placeholder for any cleanup or final steps
        }
    }
}