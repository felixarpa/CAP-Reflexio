# Classes Indexades i Variables d’Instància

Tenim dues maneres de representar objectes*Variables d’Instància* per utilitzar-los, amb nom o indexades
- Amb **nom** `name` de `GamePlayer.class`- **Indexada** `#(Jack Jill) at: 1` seria "Jack".
Des del punt de vista més a baix nivell seria:
- Objectes amb referències a altres objectes (*pointer*)- Objectes amb arrays de bytes (*word*, *long*)Fem la diferència per raons d'eficiència: emmagatzemar arrays de *bytes* (com les strings de **C**) és més eficient que emmagatzemar un array de referències, cada una d’elles apuntant a un sol *byte* i ocupant una *word*

Una **variable indexada** s'afegeix implícitament a la llista de **variables d’instància**.
- Només hi ha una variable indexada (d'instància) per classe- Accés amb `#at:` i amb `#at:put:`
Les subclasses d'una classe indexable han de ser també indexades

## IndexedObject

Declaració de la classe:

```smalltalk
Object variableSubclass: #IndexedObject    instanceVariableNames: ''    classVariableNames: ''    category: 'ClassesIndexades'
```

Exemple d'us:

```smalltalk(IndexedObject new: 2)    at: 1 put: 'Fèlix';    at: 2 put: 'Arribas';    at: 1. " Print it => 'Fèlix' "
```