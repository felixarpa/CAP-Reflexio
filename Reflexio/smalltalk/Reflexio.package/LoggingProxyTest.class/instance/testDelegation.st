running
testDelegation
    | point proxy |
    point := 1@2.
    proxy := LoggingProxy new.
    proxy become: point.

    self assert: point class = LoggingProxy.
    self assert: proxy class = Point.

    self assert: point invocationCount = 0.
    
    self assert: point + (3@4) = (4@6).
    self assert: point invocationCount = 1.