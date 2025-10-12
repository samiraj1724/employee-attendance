pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "employee-attendance:latest"
        DOCKERFILE_PATH = "Dockerfile"  // Change this if your Dockerfile is in a subfolder, e.g., "docker/Dockerfile"
    }

    stages {
        // Stage 1: Clone the repo
        stage('Clone') {
            steps {
                git branch: 'master', url: 'https://github.com/samiraj1724/employee-attendance.git'
            }
        }

        // Stage 2: Optional Workspace Check (can remove later)
        stage('Check Workspace') {
            steps {
                sh '''
                echo "Workspace path:"
                pwd
                echo "Files in workspace:"
                ls -l
                '''
            }
        }

        // Stage 3: Build Maven Project
        stage('Build Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        // Stage 4: Build Docker Image
        stage('Docker Build') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} -f ${DOCKERFILE_PATH} ."
            }
        }

        // Stage 5: Stop old container (if exists) and run Docker
        stage('Docker Run') {
            steps {
                sh '''
                docker stop employee-attendance || true
                docker rm employee-attendance || true
                docker run -d -p 8081:8080 --name employee-attendance ${DOCKER_IMAGE}
                '''
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Build and Docker deployment succeeded!'
        }
        failure {
            echo 'Pipeline failed. Check logs.'
        }
    }
}
