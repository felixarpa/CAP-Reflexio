as yet unclassified
testSuma
	self assert: eur5 + eur5 = eur10.
	self assert: eur5 + eur10 = (Pasta new moneda: 'EUR'; quantitat: 15).
	self assert: eur20 = (eur5 + eur5 + eur5 + eur5).