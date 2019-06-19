/**
 * get available sports 
 */
export async function getSports() {
    return new Promise((resolve, reject) => {
        fetch('/sports')
            .then((res) => {
                if (res.status === 200) {
                    res.json().then(resolve);
                } else {
                    reject(res.statusText);
                }
            });
    });
}

/**
 * get available sports 
 */
export async function getSportInfo(sportName) {
    try {
        const res = await fetch(`/sportinfos/name/${sportName}`);
        const result = await res.json();
        return result;
    }
    catch (error) {
        console.log(error);
    }
}
