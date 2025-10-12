pipeline {
    agent any
    stages {
        stage('Clone') {
            steps { 
                git branch: 'master', url: 'https://github.com/samiraj1724/employee-attendance.git' 
            }
        }
        stage('Build') {
            steps { sh 'mvn clean package' }
        }
        stage('Docker Build') {
            steps { sh 'docker build -t employee-attendance:latest .' }
        }
        stage('Docker Run') {
            steps {
                sh 'docker stop employee-attendance || true'
                sh 'docker rm employee-attendance || true'
                sh 'docker run -d -p 8081:8080 --name employee-attendance employee-attendance:latest'
            }
        }
    }
}
