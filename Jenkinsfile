pipeline {
    agent any

    environment {
        registry = "medrahmouni/devops"
        registryCredential = 'dockerhub'
        }
    stages{
	    stage('Checkout GIT'){
         steps {
             echo 'Pulling ...';
              git branch: 'rahmouni',
              url: 'https://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@github.com/Emnarahoui12/DevOpsProject.git';
              
         }
          
        }




        stage('Testing maven'){
            steps {
                sh """mvn -version """
            }

        }
        stage('MVN CLEAN'){
            steps {
                sh 'mvn clean'
            }
        }
        stage('MVN COMPILE'){
            steps {
                sh 'mvn compile'
            }
        }


         stage('MVN TEST') {
            steps {
                sh 'mvn test'
            }
        }
      stage('Sonatype/Nexus deploy') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			      }
     }

     stage('Build image') {
           	steps {
       		 sh "docker build -t  medrahmouni/devops ."
       		}
       		}

       		 stage('Push image') {
 		  steps  {
            script {
                    withDockerRegistry([credentialsId: "dockerhub", url: ""]) {


        	  sh 'docker push medrahmouni/devops'
                    }
                }
            }
        }





       stage('Run app With DockerCompose') {
              steps {
                  sh "docker-compose -f docker-compose.yml up -d  "
              }
              }

    stage('Cleaning up') {
         steps {
			sh "docker rmi -f medrahmouni/devops"
         }
     }
	stage('Sending email'){
	            steps {
	             mail bcc: '', body: '''Hello from devopsproject,
	             Devops Pipeline with success.
	             Cordialement''', cc: '', from: '', replyTo: '', subject: 'Devops', to: 'weldrahmouni90@gmail.com'
	             }
	        }


    }
}
