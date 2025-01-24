#!/bin/bash

# Colors for better output
RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Create basic directory structure if it doesn't exist
mkdir -p problems/basic/patterns

# Function to create a new problem
create_problem() {
    echo -e "${BLUE}Select category:${NC}"
    echo "1) Basic Patterns"
    echo "2) Basic Math"
    echo "3) Arrays"
    read category_choice

    case $category_choice in
        1)
            category_path="basic/patterns"
            ;;
        2)
            category_path="basic/math"
            ;;
        3)
            category_path="arrays"
            ;;
        *)
            echo -e "${RED}Invalid choice!${NC}"
            return 1
            ;;
    esac
    
    echo -e "${BLUE}Enter problem number:${NC}"
    read problem_number
    
    # Create problem directory
    problem_dir="problems/$category_path/$problem_number"
    mkdir -p "$problem_dir"
    
    # Create README for the problem
    echo -e "${BLUE}Enter problem description:${NC}"
    read problem_desc
    
    cat > "$problem_dir/README.md" << EOF
# Problem $problem_number

## Problem Description
$problem_desc

## Solutions
- [ ] JavaScript
- [ ] TypeScript
- [ ] Go
EOF
    
    echo -e "${GREEN}Problem directory created successfully!${NC}"
}

# Function to run a solution
run_solution() {
    echo -e "${BLUE}Select category:${NC}"
    echo "1) Basic Patterns"
    echo "2) Basic Math"
    echo "3) Arrays"
    read category_choice

    case $category_choice in
        1)
            category_path="basic/patterns"
            ;;
        2)
            category_path="basic/math"
            ;;
        3)
            category_path="arrays"
            ;;
        *)
            echo -e "${RED}Invalid choice!${NC}"
            return 1
            ;;
    esac

    # List available problems in the category
    echo -e "${BLUE}Available problems in $category_path:${NC}"
    ls "problems/$category_path"
    
    echo -e "${BLUE}Enter problem number:${NC}"
    read problem_number
    
    if [ ! -d "problems/$category_path/$problem_number" ]; then
        echo -e "${RED}Problem not found!${NC}"
        return 1
    fi
    
    echo -e "${BLUE}Select language:${NC}"
    echo "1) JavaScript"
    echo "2) TypeScript"
    echo "3) Go"
    read lang_choice
    
    case $lang_choice in
        1)
            if [ -f "problems/$category_path/$problem_number/solution.js" ]; then
                node "problems/$category_path/$problem_number/solution.js"
            else
                echo -e "${RED}No JavaScript solution found!${NC}"
            fi
            ;;
        2)
            if [ -f "problems/$category_path/$problem_number/solution.ts" ]; then
                tsc "problems/$category_path/$problem_number/solution.ts" && node "problems/$category_path/$problem_number/solution.js"
            else
                echo -e "${RED}No TypeScript solution found!${NC}"
            fi
            ;;
        3)
            if [ -f "problems/$category_path/$problem_number/solution.go" ]; then
                go run "problems/$category_path/$problem_number/solution.go"
            else
                echo -e "${RED}No Go solution found!${NC}"
            fi
            ;;
        *)
            echo -e "${RED}Invalid choice!${NC}"
            ;;
    esac
}

# Main menu
while true; do
    echo -e "\n${GREEN}DSA Practice Manager${NC}"
    echo "1) Create new problem"
    echo "2) Run solution"
    echo "3) Exit"
    read choice

    case $choice in
        1)
            create_problem
            ;;
        2)
            run_solution
            ;;
        3)
            echo -e "${GREEN}Goodbye!${NC}"
            exit 0
            ;;
        *)
            echo -e "${RED}Invalid choice!${NC}"
            ;;
    esac
done