# Launch Interceptor Decision Program

#### Java program to decide the launch of a hypothetical ballistic missile interceptor

This project determines whether an interceptor launch should be authorized based on radar tracking information as part of a hypothetical anti-ballistic missile system. The radar data points are evaluated against 15 geometric Launch Interceptor Conditions (LICs), which are then combined using a Logical Connector Matrix (LCM) and Preliminary Unlocking Vector (PUV) to decide the final launch signal.

## Usage

### Dependencies
- JDK 21+
- JUnit 5
- Maven 3.8+

### Build and run
To compile:
```bash
mvn compile
```
To run tests:
```bash
mvn test
```
The main entry point is the `Decide` class, which has a `decide` method that takes radar points, parameters, and logical matrices as input and returns the launch decision as output.

## Contributions
This project was developed by Group 21:
- **Barnabas Tanczos:** class skeletons, Parameters record, CMV calculation, LIC iteration helpers, LICs 5-9, geometry utils 3-4, README, way of working, corresponding tests
- **Lucas Lund:** GitHub setup, FUV calculation, LICs 0-4, geometry utils 1-2, corresponding tests
- **Shengye (Óscar) Huang Wu:** PMU calculation, LICs 10-14, geometry utils 5-6, Maven, corresponding tests

## License
This project is licensed under the MIT License. You are free to use, modify, and distribute this software in accordance with the terms described in the LICENSE file included in this repository.