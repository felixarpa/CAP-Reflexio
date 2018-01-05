running
run: aSelector with: anArray in: aReceiver
	invocationCount := invocationCount + 1.
	^ aReceiver withArgs: anArray executeMethod: method