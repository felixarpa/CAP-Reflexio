# Sobreescriure `#doesNotUnderstand:`

Cal crear un objecte mínim. Embolica un objecte normal (*wrap*), no enten quasi res i redefineix `#doesNotUnerstand:`. És superclasse de `nil` o `ProtoObject` per no tenir la implementació normal de `#doesNotUnerstand:`. Finalment utilitxa el metode `#become:` per substituir i controlar l'objecte a controlar.

```smalltalk
ProtoObject subclass: #LoggingProxy
    instanceVariableNames: 'subject invocationCount'
    classVariableNames: ''
    category: 'Reflexio'
```

La idea es col·locar aquest objecte entre el missatge i l'objecte receptor (`receiver`).

```smalltalk
initialize
    invocationCount := 0.
    subject := self.
```

La variable d'instància `subject` serà on enviarem el missatge quan l'objecte no l'entengui:

```smalltalk
doesNotUnderstand: aMessage 
    Transcript show: 'performing ', aMessage printString; cr.
    invocationCount := invocationCount + 1.
    ^ aMessage sendTo: subject
```

###### Exemple

```smalltalk
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
```

Quan `point` es transforma en el proxy només sap fer `#doesNotUnderstand`. Ja no és `(1@2)`, el proxy passa ser-ho. Quan se li envia el missatge `#+` a `point`, ja no l'entén i executa `#doesNotUnderstand`. A `#doesNotUnderstant`, point escriu pel `Transcrip`, incrementa el `invocationCount` i finalment envia el missatge al `subject`.

La variable `subject` s'ha inicialitzat amb `self`, és a dir, `proxy`. `proxy` s'ha transformat en el punt `point`, ho podem veure en el primer `#assert:`. Aixi que envia el missatge a `proxy`, que ara és el punt `(1@2)` i si que l'enten.
