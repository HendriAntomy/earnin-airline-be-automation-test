#!/bin/bash
set -e

# Start PostgreSQL in the background
docker-entrypoint.sh postgres &

# Wait for PostgreSQL to be ready
until pg_isready -h localhost -p 5432 -U postgres; do
  echo "Waiting for PostgreSQL to be ready..."
  sleep 2
done

# Execute your SQL script
psql -h localhost -U postgres airline -a -f /home/scripts/schema.sql

# Bring the PostgreSQL process to the foreground
wait