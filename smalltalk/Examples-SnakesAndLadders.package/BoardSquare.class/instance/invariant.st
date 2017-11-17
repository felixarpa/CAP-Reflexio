initialize-release
invariant
	^ board notNil
		and: [ position notNil
		and: [ position >= 0 
		and: [ position <= board lastPosition]]]