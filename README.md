# CAP-Reflexio

Codi i apunts de la primera part de reflexió de l'assignatura Conceptes Avançats de Programació (CAP)

## Contingut

- [Introducció a Smalltalk]()
	- [Pasta](smalltalk/Pasta.package/Pasta.class)
	- [PastaTest](smalltalk/Pasta.package/PastaTest.class)

- [Reflexió](reflexio)
	- [Introducció](reflexio/introduccio.md)
	- [Reflexió en Smalltalk](reflexio/reflexio-en-smalltalk.md)
	- [Continuacions](hreflexio/reflexio-en-smalltalk.md#continuacions)
	- [Exercicis de reflexió en Smalltalk](hreflexio/exercicis-smalltalk.md)
	- [Reflexió en Java](hreflexio/reflexio-en-java.md)

## Entorn de treball

### Pharo 3.0

#### macOS

Instal·lar **Pharo 3.0** a Mac és molt fàcil. Ves a la carpeta `pharo/` d'aquest repositori i descomprimeix l'arxiu `pharo-mac-stable.zip`. Apareixerà l'aplicació Pharo, ja està.

#### Linux (FIB)

Als ordinadors de la FIB (amb **Linux**, no utilitzeu Windows, si us plau) pharo ja està instal·lat. Per iniciar-lo cal executar la següent comanda: `pharo-ui <image>`.

### Entorn de Pharo

Per començar a utilitzar **Pharo 3.0** es necessita una imatge. Està l'última versió de **Pharo 3.0** comprimida a l'arxiu `Pharo-Image-3.0-latest.zip`. Aquesta imatge només té les classes per defecte de Smalltalk, no té cap classe ni paquet utilitzat a classe o en aquest repositori.

Per poder utilitzar aquest repositori, cal seguir els següents passos. Primer de tot, cal comprovar que el Pharo tingui instal·lat el `filetree`: Botó dret, obrim *Monticello Browser* i li donem a `+Repository`. Si apareix la opciò de `filetree` no cal instal·lar-lo i pots saltar directament a [Clona el repositori](#clona-el-repositori).

#### Instal·la `filetree`

Dintre de l'entorn de **Pharo**, obra un Workspace amb el botó dret i obra un `Workspace` i executa (`cmd + D`, `ctrl + D`) el següent codi:

```smalltalk
Gofer new
    url: 'http://ss3.gemstone.com/ss/FileTree';
    package: 'ConfigurationOfFileTree';
    load.
((Smalltalk at: #ConfigurationOfFileTree) project version: #'stable') load.
```

Això instal·larà els paquets necessaris per poder instal·lar extensions de *github*.

Ara executa més codi per instal·lar `FileTree` a través de *github*:

```smalltalk
Metacello new
    baseline: 'Metacello';
    repository: 'github://dalehenrich/metacello-work:master/repository';
    get.
Metacello new
    baseline: 'Metacello';
    repository: 'github://dalehenrich/metacello-work:master/repository';
  onConflict: [:ex | ex allow];
    load.
```

I finalment:

```smalltalk
Metacello new
    baseline: 'FileTree';
    repository: 'github://dalehenrich/filetree:pharo3.0/repository';
    load.
```

*Si estàs utilitzant una altra versió de Pharo que no sigui la 3.0 canvia on posa `filetree:pharo3.0` per la versió que toqui (pharo1.1, pharo1.3, pharo1.4, pharo2.0).*

Ara que ja tenim el filetree al nostre **Pharo**.

#### Clona el repositori

Ara cal clonar aquest repositori on vulguis, si no el tenies ja. Fora del **Pharo** obra la terminal i executa:

```bash
git clone https://github.com/felixarpa/CAP-Reflexio.git
```

#### Obra el repositori

Ara tornem al **Pharo** per obrir el repositori i poder accedir al codi.

1. Obrim *Monticello Browser* i li donem a `+Repository`.
2. Seleccionem `filetree://`.
3. Escollim la carpeta `smalltalk/` d'aquest repositori clonat al vostre ordinador. Un cop acceptem s'obrirà una nova finestra amb nom *Repository: filtree://<path>/CAP-Reflexio/smalltalk* on apareixeran tots els paquets que he utilitzat aquest curs.
4. Seleccioneu els paquets que vulgueu i doneu-li a `Load` perquè apareguin al *Nautilus*.
