# Reflexió en Smalltalk

- [Pròleg](https://github.com/felixarpa/CAP-Reflexio/tree/master/reflexio/reflexio-en-smalltalk.md#pròleg)
	- [Les Mestaclasses en 7 parts](https://github.com/felixarpa/CAP-Reflexio/tree/master/reflexio/reflexio-en-smalltalk.md#les-mestaclasses-en-7-parts)
	- [Classes Indexades i Variables d’Instància](https://github.com/felixarpa/CAP-Reflexio/tree/master/reflexio/reflexio-en-smalltalk.md#classes-indexades-i-variables-dinstància)
	- [Variables de class-instància](https://github.com/felixarpa/CAP-Reflexio/tree/master/reflexio/reflexio-en-smalltalk.md#variables-de-classe-instància)
	- [Variables de class](https://github.com/felixarpa/CAP-Reflexio/tree/master/reflexio/reflexio-en-smalltalk.md#variables-de-classe)
- [Reflexió](https://github.com/felixarpa/CAP-Reflexio/tree/master/reflexio/reflexio-en-smalltalk.md#reflexió)

## Pròleg

### Les *Mestaclasses* en 7 parts

#### 1. Tot objecte és instància d’una classe

#### 2. Tota classe hereta eventualment d’Object

Tot és un objecte. La classe de cada objecte hereta d'*Object*

Quan un objecte rep un missatge, el mètode es busca
al diccionari de mètodes de la seva classe, i, si cal, a
les seves superclasses, fins arribar a *Object*.

*Object* representa el comportament comú a tots els objectes (com la gestió d'errors, per exemple). Totes les classes haurien d'heretar d'*Object*.

#### 3. Tota classe és instància d’una metaclasse

Com a Smalltalk tot és un objecte, les **classes també son objectes**. Cada classe *X* és l'única instància de la seva *metaclasse* anomenada *X class*.

Les *metaclasses* es crean quan es crea un classes de forma implícita. Les *metaclasses* no es comparteixen, cada classe és **instància única** de la seva *metaclasse*.

![](./res/metaclasses00.png)

Per accedir a la *metaclasse* d'una classe s'ha d'activar el *class side* al Pharo.

#### 4. La jerarquia de metaclasses és equivalent a la jerarquia de classes

![](./res/metaclasses01.png)

#### 5. Tota metaclasse hereta de Class i Behavior

![](./res/metaclasses02.png)

##### Behavior

És el mínim estat necessari pels objectes que tenen instancies. Té l'interfície bàsica pel compilador.

##### ClassDescription

Afageix algunes utilitats a *Behavior*. És una classe abstracte, les utilitats que proporciona estan pensades per *Class* i *Metaclass*.

##### Class

Representa el comportament comú de totes les classes (com, compilació, emmagatzematge de mètodes, variables d'instancia, etc).

#### 6. Tota metaclass és instància de Metaclass

![](./res/metaclasses03.png)

##### Metaclass

Representa el comportament comú de totes les *metaclasses* 

#### 7. La metaclasse de Metaclass és instància de Metaclass

![](./res/metaclasses04.png)

```smalltalk
MetaclassHierarchyTest >> testHierarchy
    "The class hierarchy"
    self assert: SnakeSquare superclass = BoardSquare.
    self assert: BoardSquare superclass = Object.
    self assert: Object superclass superclass = nil.
    "The parallel metaclass hierarchy"
    self assert: SnakeSquare class name = 'SnakeSquare class'.
    self assert: SnakeSquare class superclass = BoardSquare class.
    self assert: BoardSquare class superclass = Object class.
    self assert: Object class superclass superclass = Class.
    self assert: Class superclass = ClassDescription.
    self assert: ClassDescription superclass = Behavior.
    self assert: Behavior superclass = Object.
    "The Metaclass hierarchy"
    self assert: SnakeSquare class class = Metaclass.
    self assert: BoardSquare class class = Metaclass.
    self assert: Object class class = Metaclass.
    self assert: Class class class = Metaclass.
    self assert: ClassDescription class class = Metaclass.
    self assert: Behavior class class = Metaclass.
    self assert: Metaclass superclass = ClassDescription.
    "The fixpoint"
    self assert: Metaclass class class = Metaclass
```

### Classes Indexades i Variables d’Instància

Tenim dues maneres de representar objectes
*Variables d’Instància* per utilitzar-los, amb nom o indexades

- Amb **nom** `name` de `GamePlayer.class`
- **Indexada** `#(Jack Jill) at: 1` seria "Jack".

Des del punt de vista més a baix nivell seria:

- Objectes amb referències a altres objectes (*pointer*)
- Objectes amb arrays de bytes (*word*, *long*)

Fem la diferència per raons d'eficiència: emmagatzemar arrays de *bytes* (com les strings de **C**) és més eficient que emmagatzemar un array de referències, cada una d’elles apuntant a un sol *byte* i ocupant una *word*

Una **variable indexada** s'afegeix implícitament a la llista de **variables d’instància**.

- Només hi ha una variable indexada (d'instància) per classe
- Accés amb `#at:` i amb `#at:put:`

Les subclasses d'una classe indexable han de ser també indexades

#### IndexedObject

Declaració de la classe:

```smalltalk
Object variableSubclass: #IndexedObject
    instanceVariableNames: ''
    classVariableNames: ''
    category: 'ClassesIndexades'
```

Exemple d'us:

```smalltalk
(IndexedObject new: 2)
    at: 1 put: 'Fèlix';
    at: 2 put: 'Arribas';
    at: 1. " Print it => 'Fèlix' "
```

[Implementació](https://github.com/felixarpa/CAP-Reflexio/tree/master/smalltalk/ClassesIndexades.package/IndexedObject.class)

### Variables de classe-instància

Les classes són objectes, instàncies de la seva metaclasse, així que poden tenir variables d'instància.

#### Exemple: El patró Singleton

Volem que la classe sigui singleton ([codi](https://github.com/felixarpa/CAP-Reflexio/tree/master/smalltalk/Patterns.package/Singleton.class)).

```smalltalk
Object subclass: #Singleton    instanceVariableNames: ''    classVariableNames: ''    category: 'Patterns'
```

I al class side (metaclasse):

```smalltalk
Singleton class    instanceVariableNames: 'uniqueInstance'
```

Ara toca controlar la creació de lobjecte *Singleton* i l'access a *uniqueInstance*:

```smalltalk
new    "You cannot create a new singleton object"
    self error: 'Use uniqueInstance to get the unique instance of this object'
```

```smalltalk
uniqueInstance    "get the unique instance of this class"    uniqueInstance isNil       ifTrue: [ uniqueInstance := self basicNew initialize ].    ^ uniqueInstance
```

### Variables de classe

Serveixen per compartir informació entre instàncies d'una classe. Son variables compartides i direcament accessibles per totes les instàncies de la classe i la subclasse. Comença amb una lletra majúscula.

## Reflexió



