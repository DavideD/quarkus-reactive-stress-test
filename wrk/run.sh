#!bin/bash
set -e

cd "$( dirname "${BASH_SOURCE[0]}" )" 
cd lua-scripts
wrk --threads "${1:-2}" --connections "${2:-4}" --duration "${3:-30s}" --rate 2000 --script create_animals.lua http://localhost:8080
