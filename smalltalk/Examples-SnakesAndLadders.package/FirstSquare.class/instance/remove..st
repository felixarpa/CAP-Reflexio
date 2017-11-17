playing
remove: aPlayer
	self assert: (players includes: aPlayer).
	players remove: aPlayer.