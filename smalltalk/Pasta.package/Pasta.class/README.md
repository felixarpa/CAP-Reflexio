# Pasta

## Class side

### moneda: quantitat:

```smalltalk
moneda: unaMoneda quantitat: unNumero    ^ self new moneda: unaMoneda; quantitat: unNumero.
```

## Accessing

*Getters* i *setters* generats automaticament al fer, a **Pasta**, `Refactoring > Class Refactoring > Create Accessors`

### moneda

```smalltalk
moneda
    ^ moneda
```

### moneda:

```smalltalk
moneda: anObject
    moneda := anObject
```

### quantitat

```smalltalk
quantitat
    ^ quantitat
```

### quantitat:

```smalltalk
quantitat: anObject
    quantitat := anObject
```

## Comparing

### =

```smalltalk
= unaPasta     ^ self moneda = unaPasta moneda and: [ self quantitat = unaPasta quantitat ]
```

## Aritmetic

### +

```smalltalk
+ unaPasta    ^ self moneda = unaPasta moneda        ifTrue: [ Pasta moneda: self moneda quantitat: ( self quantitat + unaPasta quantitat ) ]        ifFalse: [ self error: 'No es poden usar monedes diferents' ]
```