pipeline {
    agent any
 

    stages {
        stage('Git') {
            steps {
            
                git branch: 'nasri', url: 'https://github.com/Emnarahoui12/DevOpsProject.git',
                credentialsId :'2a60d735-a591-4cd4-a60d-1d8f57e1d47a'
                
            }

        
        }
        stage('Maven Package'){
            steps {
                sh " mvn -version "
                sh " java -version "
                sh " mvn package -e "
            }
        }
        
        stage("Maven Clean"){
            steps {
                sh " mvn clean -e "
                
            }
        }

         stage("Maven Compile"){
            steps {
                sh " mvn compile -e "
                
            }
        }

        stage("Maven Install"){
            steps {
                sh " mvn install "
                
            }
        }
        }
        
        }