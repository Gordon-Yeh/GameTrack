export async function getUsersInAllEvents() {
    try {
        const res = await fetch("/users/allEvents");
        const result = await res.json();
        return result;
    }
    catch (error) {
        console.log(error);
    }
}

export async function getUsersLeaderboards(sport) {
    try {
        const res = await fetch(`/users/leaderboards/${sport}`);
        const result = await res.json();
        return result;
    }
    catch (error) {
        console.log(error);
    }
}

export async function getTopLocations(sport) {
    try {
        const res = await fetch(`/locations/leaderboards/${sport}`);
        const result = await res.json();
        return result;
    }
    catch (error) {
        console.log(error);
    }
}


export async function getUsersCount() {
    try {
        const res = await fetch(`/users/count`);
        const result = await res.json();
        return result;
    }
    catch (error) {
        console.log(error);
    }
}

export async function getEventsCount() {
    try {
        const res = await fetch(`/events/count`);
        const result = await res.json();
        return result;
    }
    catch (error) {
        console.log(error);
    }
}
