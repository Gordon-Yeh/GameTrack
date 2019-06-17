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
