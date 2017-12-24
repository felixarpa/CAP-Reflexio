documentation
example
	"self example playToEnd"

	^ (self new)
		add: FirstSquare new;
		add: (LadderSquare forward: 4);
		add: BoardSquare new;
		add: BoardSquare new;
		add: BoardSquare new;
		add: BoardSquare new;
		add: (LadderSquare forward: 2);
		add: BoardSquare new;
		add: BoardSquare new;
		add: BoardSquare new;
		add: (SnakeSquare back: 6);
		add: BoardSquare new;
		join: (GamePlayer named: 'Jack');
		join: (GamePlayer named: 'Jill');
		yourself