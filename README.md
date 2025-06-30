# cs320

## Overview
This repository contains my work from CS 320: Software Test Automation & QA, demonstrating my skills in software testing, automation, and quality assurance. The projects showcase my ability to create comprehensive unit tests, analyze testing approaches based on requirements, and apply appropriate testing strategies to ensure software quality.

## Project Artifacts
###Contact Service Implementation

- Contact.java - Contact class with validation requirements
- ContactService.java - Service class managing contact operations
- ContactTest.java - Comprehensive unit tests for Contact class
- ContactServiceTest.java - Unit tests for ContactService operations

### Project Summary Report

- CS320-project2_student_papers.docx - Detailed analysis of testing approach and reflection on software testing practices

## Key Features Demonstrated
### Comprehensive Testing Strategy

- Unit Testing: Individual component testing with JUnit 5
- Boundary Value Analysis: Testing at input domain boundaries
- Exception Testing: Proper validation and error handling
- Code Coverage: Achieved 80%+ coverage across all classes

### Validation Requirements Met

- Contact ID: ≤10 characters, unique, immutable
- Names: ≤10 characters each, non-null
- Phone: Exactly 10 digits, numeric only
- Address: ≤30 characters, non-null

### Professional Testing Practices

- Clean test initialization with @BeforeEach
- Descriptive test method names
- Comprehensive assertion usage
- Systematic requirement validation

## Reflection
### How can I ensure that my code, program, or software is functional and secure?
Ensuring functional and secure software requires a multi-layered approach centered on comprehensive testing and validation. In this project, I implemented several key practices:
### Comprehensive Unit Testing: 
I created extensive unit tests covering all code paths, including edge cases and error conditions. For example, my testContactIdTooLong() method ensures the system properly rejects invalid inputs, while testAddContactDuplicateId() validates business logic preventing duplicate entries.
### Input Validation: 
Every field in the Contact class includes rigorous validation - from null checks to character limits to format validation (like the 10-digit phone requirement). This prevents injection attacks and data corruption.
###Exception Handling: 
I systematically tested exception paths using assertThrows() to ensure the system fails gracefully and provides meaningful error messages rather than exposing internal vulnerabilities.
### Boundary Value Analysis: 
Testing at the exact limits of input ranges (like 10-character names) helps identify off-by-one errors and ensures the system behaves correctly at critical boundaries.
Moving forward, I would also incorporate integration testing, security scanning tools, and code reviews to further enhance software security and functionality.
## How do I interpret user needs and incorporate them into a program?
User needs interpretation requires careful analysis of requirements and translation into testable specifications. In this project, I demonstrated this through:
### Requirements Analysis: 
I analyzed the contact management requirements and identified that users need reliable data storage with specific validation rules. The 10-character limit on names and exact 10-digit phone numbers reflect real-world usability constraints.
### Test-Driven Validation: 
My tests like testContactCreationValid() and testUpdateContactAllFields() directly verify that user requirements are met. Each test method corresponds to a specific user need - creating contacts, updating information, preventing duplicates.
### Edge Case Consideration: 
Users often input unexpected data, so I tested scenarios like null values, empty strings, and boundary conditions. The testPhoneNonDigits() test ensures users receive clear feedback for invalid phone formats.
### Functional Completeness: 
I ensured all CRUD operations (Create, Read, Update, Delete) work correctly, as users need complete contact management functionality.
The key is translating user stories into specific, testable requirements and then validating those requirements through comprehensive testing.
## How do I approach designing software?
My software design approach emphasizes quality, maintainability, and systematic validation:
### Design for Testability: 
I structured classes with clear separation of concerns - the Contact class handles data validation while ContactService manages operations. This separation makes unit testing straightforward and comprehensive.
### Validation-First Design: 
Rather than adding validation as an afterthought, I built validation into the core of each class. The Contact constructor validates all inputs, and setter methods maintain data integrity throughout the object lifecycle.
### Systematic Testing Strategy: 
I approach testing methodically, covering:

- Happy path scenarios (valid inputs, successful operations)
- Edge cases (boundary values, null inputs)
- Error conditions (invalid data, duplicate IDs)
- State verification (ensuring operations produce expected results)

### Professional Practices: 
I use industry-standard practices like:

- Descriptive naming conventions for tests and methods
- Clean initialization with @BeforeEach annotations
- Comprehensive documentation and comments
- Consistent error handling patterns

## Quality-Focused Mindset: 
As noted in my reflection, I maintain a skeptical mindset, questioning assumptions and thoroughly testing all code paths. This prevents the technical debt that results from shortcuts and inadequate testing.
Future design work will continue emphasizing these principles while incorporating additional patterns like dependency injection for better testability and design patterns for more complex systems.

## Technical Skills Demonstrated

- Java Programming: Object-oriented design with proper encapsulation
- JUnit 5: Advanced testing framework usage with annotations and assertions
- Test Design: Boundary value analysis, equivalence partitioning, error condition testing
- Code Quality: Clean code practices, comprehensive documentation
- Requirements Analysis: Translation of business requirements into technical specifications
- Quality Assurance: Systematic approach to software validation and verification

## Conclusion
This portfolio demonstrates my commitment to software quality through comprehensive testing practices. The combination of systematic unit testing, proper validation, and professional development practices ensures reliable, maintainable software that meets user requirements while preventing common security vulnerabilities.
The skills developed in this course - from test design to quality assurance mindset - form the foundation for professional software development where quality and reliability are paramount.
