# Pasta Test

### setUp

Abans de crear el metode a la classe integer `euro` per crear instancies de Pasta.

```smalltalk
setUp    Pasta new moneda: 'EUR'; quantitat: 5.    Pasta new moneda: 'EUR'; quantitat: 10.    Pasta new moneda: 'EUR'; quantitat: 20.
```

A la classe integer afegim el nou metode:

```smalltalk
euro
    ^ Pasta moneda: 'EUR' quantitat: self
```

Que retorna una instancia de pasta quan li passes el missatge `euro` a un *Integer*

```smalltalk
setUp    eur5 := 5 euro.    eur10 := 10 euro.    eur20 := 20 euro.
```

### testIguals

```smalltalk
testIguals    self assert: eur5 = eur5 .    self assert: eur5 = (Pasta new moneda: 'EUR'; quantitat: 5).    self assert: eur5 ~= eur10.
```

### testSuma

```smalltalk
testSuma    self assert: eur5 + eur5 = eur10.    self assert: eur5 + eur10 = (Pasta new moneda: 'EUR'; quantitat: 15).    self assert: eur20 = (eur5 + eur5 + eur5 + eur5).
```