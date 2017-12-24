# Singleton

La classe en si no té res, tot ho te la metaclasse.

```smalltalk
Object subclass: #Singleton    instanceVariableNames: ''    classVariableNames: ''    category: 'Patterns'
```

## Class side

aka: Metaclass, Singleton class

```smalltalk
Singleton class    instanceVariableNames: 'uniqueInstance'
```

### new

```smalltalk
new    "You cannot create a new singleton object"
    self error: 'Use uniqueInstance to get the unique instance of this object'
```

### uniqueInstance

```smalltalk
uniqueInstance    "get the unique instance of this class"    uniqueInstance isNil       ifTrue: [ uniqueInstance := self basicNew initialize ].    ^ uniqueInstance
```