pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "employee-attendance:latest"
        DOCKERFILE_PATH = "Dockerfile" // Change this if your Dockerfile is in a subfolder, e.g., "docker/Dockerfile"
    }

    stages {
        // Stage 1: Clone the repo (wipe workspace first)
        stage('Clone') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/samiraj1724/employee-attendance.git']],
                    extensions: [[$class: 'CleanBeforeCheckout']] // wipes workspace before cloning
                ])
            }
        }

        // Stage 2: Build Maven Project
        stage('Build Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        // Stage 3: Build Docker Image
        stage('Docker Build') {
            steps {
                sh '''
                if [ ! -f ${DOCKERFILE_PATH} ]; then
                    echo "ERROR: Dockerfile not found at ${DOCKERFILE_PATH}"
                    exit 1
                fi
                docker build -t ${DOCKER_IMAGE} -f ${DOCKERFILE_PATH} .
                '''
            }
        }

        // Stage 4: Stop old container (if exists) and run Docker
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
            echo 'Pipeline failed. Check logs for errors.'
        }
    }
}
