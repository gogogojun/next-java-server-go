#!/bin/bash

STACK_NAME="go--stack"

echo "Deleting stack: $STACK_NAME"
aws cloudformation delete-stack --stack-name "$STACK_NAME"

echo "Waiting for stack deletion to complete..."
aws cloudformation wait stack-delete-complete --stack-name "$STACK_NAME"
echo "🗑️ Stack deleted."
