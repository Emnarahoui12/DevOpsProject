pipeline {

	agent any

	stages {
		
		   stage('Junit') {
			steps {
				sh 'mvn test'
			      } 
		}
		
		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
		       
		/*stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=springproject  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=3c074b523d4c7c386d849a31aafe8d7ded9b0e49"
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
	/*	 stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
         			  sh 'printenv'
        			  sh 'docker build -t emnar12/projectdevops .'
	 			  sh 'docker tag emnar12/projectdevops emnar12/projectdevops:latest'
         			  sh 'docker push emnar12/projectdevops:latest'
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
		       sh 'sleep 3m '
               sh 'docker rm -f ci-spring ci-db'
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
