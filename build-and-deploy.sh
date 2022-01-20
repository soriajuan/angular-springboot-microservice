#!/bin/sh

# Directories
DOCKERS_DIR="dockers"
BACKEND_DIR="backend"
FRONTEND_DIR="frontend"
ARTIFACTS_DIR="artifacts"

echo "- Cleaning old artifacts from previous build"
rm -rf $DOCKERS_DIR/$BACKEND_DIR/$ARTIFACTS_DIR
rm -rf $DOCKERS_DIR/$FRONTEND_DIR/$ARTIFACTS_DIR

echo "- Building backend"
cd $BACKEND_DIR
mvn clean package

# Back to root directory
cd ..

echo "- Building frontend"
cd $FRONTEND_DIR

npm install
npm run build

# Back to root directory
cd ..

echo "- Creating new artifacts directory"
mkdir -p $DOCKERS_DIR/$BACKEND_DIR/$ARTIFACTS_DIR
mkdir -p $DOCKERS_DIR/$FRONTEND_DIR/$ARTIFACTS_DIR

echo "- Copying newly built artifacts"
cp $BACKEND_DIR/target/*.jar $DOCKERS_DIR/$BACKEND_DIR/$ARTIFACTS_DIR
cp $FRONTEND_DIR/dist/frontend/* $DOCKERS_DIR/$FRONTEND_DIR/$ARTIFACTS_DIR

echo "- Building/Deploying docker images"
cd $DOCKERS_DIR
docker-compose up
