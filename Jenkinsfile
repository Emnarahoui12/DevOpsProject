pipeline {

	agent any

	stages {
		
		/*stage('Junit + Mockito Test') {
			steps {
				sh 'mvn test'
			      } 
		}*/
		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
		       
	/*	stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=DevOpsProject  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=fabab3c8200a29f6d277307476e720bc4c5a9b54"
			}
		        post {
				always {
					jacoco execPattern: 'target/jacoco.exec'
				       }    
			    } 
		 }  
		stage('Sonatype/Nexus deploy') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			      }
		 }
		  stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
         			  sh 'printenv'
        			  sh 'docker build -t fares156324/fares123 .'
	 			  sh 'docker tag fares156324/fares123 fares156324/fares123:latest'
         			  sh 'docker push fares156324/fares123:latest'
         			}
     			  }
    		}*/
		 stage('Docker compose') {
      		      steps {
         parallel(
           "Docker compose": {
               sh 'docker-compose up '
           },
           "Delete running containers": {
		       sh 'sleep 4m '
               sh 'docker rm -f ci-spring ci-db ci-angular '
           }
         )
       }
     }
	}  
			post {
				success {

					echo "passed"
				}    
			       failure {
				       echo "failed"
				
		                }
		}
}
