running
setUp
	eg := self example.
	loadedDie := LoadedDie new.
	eg setDie: loadedDie.
	jack := eg players first.
	jill := eg players last.