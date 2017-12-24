# Method Wrappers

La idea és poder executar codi abans i despres de que s'executi el mètode que s'invoca. Es substitueix el mètode per un objecte que implementi `#run:with:in:`.

```smalltalk
Object subclass: #LoggingMethodWrapper
    instanceVariableNames: 'method reference invocationCount'
    classVariableNames: ''
    category: 'Reflexio'
```

```smalltalk
initializeOn: aCompiledMethod
    method := aCompiledMethod.
    reference := aCompiledMethod methodReference.
    invocationCount := 0
```

```smalltalk
run: aSelector with: anArray in: aReceiver
    invocationCount := invocationCount + 1.
    ^ aReceiver withArgs: anArray executeMethod: method
```

Apart d'això tenim el mètode `#install` (i `#uninstall`, que és molt similar) que fa el *wrap* del mètode.

```smalltalk
install
    reference actualClass methodDictionary at: reference methodSymbol put: self
```

Exemple d'execució:

```smalltalk
logger := LoggingMethodWrapper on: Integer>>#factorial.
logger invocationCount. "0"
5 factorial.
logger invocationCount. "0"
logger install.
[ 5 factorial ] ensure: [logger uninstall].
logger invocationCount. "6"
10 factorial.
logger invocationCount. "6"
```

Al fer *wrap* d'un mètode totes les instàncies queden controlades, només s'intercepten els missatges conegurs (es pot controlar només un sol mètode) i no cal compilar per instal·lar.
