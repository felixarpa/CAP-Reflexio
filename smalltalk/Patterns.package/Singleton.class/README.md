# Singleton

La classe en si no té res, tot ho te la metaclasse.

```smalltalk
Object subclass: #Singleton
```

## Class side

aka: Metaclass, Singleton class

```smalltalk
Singleton class
```

### new

```smalltalk
new
    self error: 'Use uniqueInstance to get the unique instance of this object'
```

### uniqueInstance

```smalltalk
uniqueInstance
```