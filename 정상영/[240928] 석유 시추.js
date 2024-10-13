function solution(land) {
    const n = land.length;
    const m = land[0].length;
    
    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];
    
    let max = 0;
    const visited = new Array(n).fill().map(_ => new Array(m).fill(false));
    const sizeByColumn = new Array(m).fill(0);
    
    for(let r = 0; r < n; r++) {
        for(let c = 0; c < m; c++) {
            if(land[r][c] === 1 && !visited[r][c]) {
                const queue = [[r, c]];
                visited[r][c] = true;
                let size = 0;
                const columnsAffected = new Set();
                
                while(queue.length > 0) {
                    const [currR, currC] = queue.shift();
                    size++;
                    columnsAffected.add(currC);
                    
                    for(let d = 0; d < 4; d++) {
                        const nr = currR + dr[d];
                        const nc = currC + dc[d];
                        
                        if(nr >= 0 && nr < n && nc >= 0 && nc < m && land[nr][nc] === 1 && !visited[nr][nc]) {
                            queue.push([nr, nc]);
                            visited[nr][nc] = true;
                        }
                    }
                }
                
                for(let col of columnsAffected) {
                    sizeByColumn[col] += size;
                    max = Math.max(max, sizeByColumn[col]);
                }
            }
        }
    }
    
    return max;
}
