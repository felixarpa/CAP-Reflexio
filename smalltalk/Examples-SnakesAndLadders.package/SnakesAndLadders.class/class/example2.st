documentation
example2
	"self example2 playToEnd"

	^ (self new)
		add: FirstSquare new;
		add: BoardSquare new;
		add: (LadderSquare forward: 4);
		add: BoardSquare new;
		add: BoardSquare new;
		add: (SnakeSquare back: 2);
		add: BoardSquare new;
		add: (LadderSquare forward: 3);
		add: BoardSquare new;
		add: BoardSquare new;
		add: (SnakeSquare back: 4);
		add: BoardSquare new;
		add: BoardSquare new;
		join: (GamePlayer named: 'Jack');
		join: (GamePlayer named: 'Jill');
		yourself