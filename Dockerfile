steps:
  # Build the Spring Boot app
  - name: 'maven:3.8.4-openjdk-17'
    entrypoint: 'mvn'
    args: ['clean', 'install']


  # Step 2: Build the Docker container
  - name: 'gcr.io/cloud-builders/docker'
    args: ['build', '-t', 'gcr.io/$PROJECT_ID/hitech-api', '.']

#  # Step 3: Copy the MySQL credentials JSON file to the Docker container
#  - name: 'gcr.io/cloud-builders/docker'
#    args: [ 'cp', '/appkey/credentials.json', 'gcr.io/$PROJECT_ID/hitechdocomapp:/app/credentials.json' ]


  # Push the container image to Google Container Registry
  - name: 'gcr.io/cloud-builders/docker'
    args: ['push', 'gcr.io/$PROJECT_ID/hitech-api']

  # Deploy container image to Cloud Run
#  - name: 'gcr.io/google.com/cloudsdktool/cloud-sdk'
#    entrypoint: gcloud
#    args:
#     -  'run'
#     -  'deploy'
#     -  'hitechdocomapp'
#     -  '--image'
#     -  'gcr.io/$PROJECT_ID/hitechdocomapp:$COMMIT_SHA'
#     -  '--region'
#     -  'us-central1'
#     - '--platform'
#     - 'managed'
#     - '--allow-unauthenticated'

  # Step 5: Deploy to Cloud Run with the attached MySQL credentials
  - name: 'gcr.io/cloud-builders/gcloud'
    args:  ['run', 'deploy', 'hitech-api', '--image', 'gcr.io/$PROJECT_ID/hitech-api', '--platform', 'managed', '--region', 'us-central1','--allow-unauthenticated' ]

   # images:
   #   - 'gcr.io/$PROJECT_ID/hitechdocomapp:$COMMIT_SHA'
