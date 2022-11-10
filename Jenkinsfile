pipeline {
    agent any
	
	
   
	 tools {
        maven '3.8.1'
    }
	
    stages {
        
        stage('Maven version') {
            steps {
                sh 'mvn --version'
            }
        }
		
		
        stage('Git Code') {
            steps {
                git branch: 'mariem', 
				url: 'https://github.com/Emnarahoui12/DevOpsProject',
				credentialsId : 'ba06947d-89eb-47f2-9005-584063266420' 
            }
        }
		
		
        stage('BUILD') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
            
        }
        
        stage('MVN SONARQUBE') {
             steps {
        withSonarQubeEnv(installationName: 'sonarqube1') { 
          sh 'mvn sonar:sonar'
        }
      }
    }
    
       
        
 
               
            }
      
        
    }