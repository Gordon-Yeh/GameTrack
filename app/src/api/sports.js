/**
 * get available sports 
 */
export async function getSports() {

    try {
        const res = await fetch("/sports");
        const result = await res.json();
        return result;
    }
    catch (error) {
        console.log(error);
    }
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
