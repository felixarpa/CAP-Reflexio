playing
playToEnd
	"SnakesAndLadders example playToEnd"
	Transcript open.
	Transcript
		show: self asString;
		cr;
		cr.
	[self isNotOver] whileTrue: 
			[Transcript
				show: self playOneMove asString;
				cr.
			Transcript
				show: self asString;
				cr;
				cr]