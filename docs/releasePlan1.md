# Release Plan 1

In this release plan, I aim to deploy the IOT Blockchain functionality so that the fog computing nodes can connect to the IOT devices.

## Iteration Plan 1

## User Stories

As part of my initial requirements phase, I have generated a list of user stories that I will focus on during my first XP iteration.
| Story ID | Velocity Point | User Story                                                   | Acceptance Criteria                                          |
| -------- | -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1        | 5              | *As a non-registered user*, I want to be able to register the edge node to my account (coordinator off-edge) | Scenario: Non-registered user will submit registration form with valid data - system will store their account credentials onto the local fog layer. |
| 2        | 8              | *As a registered user*, I want to be able to connect my local IOT devices to the edge node, so that they can be accessed through the Blockchain application. | Scenario: Registered user selects pairing mode to pair the IOT device using the coordinator by specifying the type of IOT device they are connecting (e.g. MQTT or GPIO) and then the user is able to assign a device identifier and then it can be joined to an existing node |
| 3        | 13             | *As a registered user*, I want to be able to view the recent IOT data transactions from the Blockchain - so that I can access historical data when outside the local network (cloud layer). | Scenario: User will access the React.js frontend website with authenticated credentials that gives access to the block explorer where recent IOT transactions are seen. In addition, if IOT data can be visualised - this will be used to make it accessible for the registered user. |
| 4        | 21             | *As a registered user*, I want to be able to connect an already existing IOT network that is using the application's P2P network so that I can access this device through the Blockchain application. | Scenario: Registered user will be able to pair fog nodes together under a P2P network, the application will list available fog node hosts (hostname/IP address) and then give the user the option to join a fog node to the network. |

I have defined my velocity points as following - I have used the Fibonacci sequence as it makes it easier for me to assign appropriate velocity points as the difference in weighting between each metric is doubled, making me choose more appropriately compared to a scale of 1-10 that incremented by a whole number.

I have mixed this approach in from Planning Poker - though instead of the estimation being approximated from a team, it is based on my own opinions. This has been done as part of the research in the literature where it is found that '60-80% of projects encounter encounter effort and/or schedule overruns' [1]. This investigation on using Planning Poker for a group project resulted in 'statistically significantly more optimistic than the statistical combination of their individual estimates' [1].

| Velocity Points | Time Estimation     |
| --------------- | ------------------- |
| 1               | Less than half hour |
| 2               | Less than a hour    |
| 3               | Less than 12 hours  |
| 5               | Less than a day     |
| 8               | Less than 3 days    |
| 13              | Less than a week    |
| 21              | Less than two weeks |

### References

[1] Mahnič, V. and Hovelja, T. (2012) ‘On using planning poker for estimating user stories’, *Journal of Systems and Software*, 85(9), pp. 2086–2095. doi:[10.1016/j.jss.2012.04.005](https://doi.org/10.1016/j.jss.2012.04.005).