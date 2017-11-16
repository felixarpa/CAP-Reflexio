# CAP-Reflexio

Codi i apunts en markdown de la primera part de reflexió de l'assignatura Conceptes Avançats de Programació (CAP)

## Entorn de treball

### Pharo 3.0 (macOS)

Instal·lar **Pharo 3.0** a Mac és molt fàcil. Ves a la carpeta `pharo/` d'aquest repositori i descomprimeix l'arxiu `pharo-mac-stable.zip`. Apareixerà l'aplicació Pharo, ja està.

### Pharo Image

Per començar a utilitzar **Pharo 3.0** es necessita una imatge. Està l'última versió de **Pharo 3.0** comprimida al arxiu `Pharo-Image-3.0-latest.zip`.

### Entorn de pharo

Per poder utilitzar aquest repositori al Pharo cal seguir els següents passos:

#### Instal·la `filetree` a Pharo

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
Metacello new
    baseline: 'FileTree';
    repository: 'github://dalehenrich/filetree:pharo3.0/repository';
    load.
```

*Si estás utilitzant una altra versió de Pharo que no sigui la 3.0 canvia on posa `filetree:pharo3.0` per la versió que toqui (pharo1.1, pharo1.3, pharo1.4, pharo2.0).*

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
3. Escullim la carpeta `smalltalk/` d'aquest repositori clonat al vostre ordinador. Un cop acceptem s'obrirà una nova finestra amb nom *Repository: filtree://<path>/CAP-Reflexio/smalltalk* on apareixeran tots els paquets que he utilitzat aquest curs.
4. Seleccioneu els paquets que vulgueu i doneu-li a `Load` per que apareguin al *Nautilus*.

## Contingut

- [Pasta](https://github.com/felixarpa/CAP-Reflexio/tree/master/smalltalk/Pasta.package/Pasta.class)
- [PastaTest](https://github.com/felixarpa/CAP-Reflexio/tree/master/smalltalk/Pasta.package/PastaTest.class)