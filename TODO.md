- CellWithSingleCandidate 
    - extract rules by row, column, square
    - rename
  
grid --> candidates --> rules
             |
             |
        these can be calcualated in a smarter way than the current

- Investigare regola per risolvere questo:
  /**
  --	02	03	01	--	06
  01	--	--	--	03	02
  06	05	02	03	01	04
  03	01	04	02	06	05
  02	03	--	--	--	01
  --	--	01	--	02	03
  */


strategies:
- row with one empty cell --> ZoneWithOneEmptyCellSolution
- column with one empty cell --> ZoneWithOneEmptyCellSolution
- square with one empty cell --> ZoneWithOneEmptyCellSolution
- usa i candidati del quadrato per calcolare i candidati della cella --> SquareStrategyByCell
- cell with single candidate --> CellWithSingleCandidate


Grid