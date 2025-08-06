#!/bin/bash

STACK_NAME="go--stack"
TEMPLATE_FILE="ec2_alb_as.yaml"
KEY_NAME="next-dev-key"

echo "Creating stack: $STACK_NAME"
aws cloudformation create-stack \
  --stack-name "$STACK_NAME" \
  --template-body file://$TEMPLATE_FILE \
  --parameters ParameterKey=KeyName,ParameterValue=$KEY_NAME \
  --capabilities CAPABILITY_NAMED_IAM

echo "Waiting for stack creation to complete..."
aws cloudformation wait stack-create-complete --stack-name "$STACK_NAME"
echo "✅ Stack created."

echo "Fetching Load Balancer DNS..."
ALB_DNS=$(aws cloudformation describe-stacks \
  --stack-name "$STACK_NAME" \
  --query "Stacks[0].Outputs[?OutputKey=='LoadBalancerDNS'].OutputValue" \
  --output text)

echo "🌐 Access your web app at: http://$ALB_DNS"
