import { useEffect, useState } from "react";

// Define Habit type
interface Habit {
  id: number;
  habitName: string;
  type: string;
}

export default function App() {
  const [habits, setHabits] = useState<Habit[]>([]);
  const [habitName, setHabitName] = useState<string>("");
  const [type, setType] = useState<string>("");
  const [habitId, setHabitId] = useState<string>("");
  const [singleHabit, setSingleHabit] = useState<Habit | null>(null);

  const BASE_URL = "http://localhost:8080/";

  // GET all habits
  const fetchHabits = async () => {
    try {
      const res = await fetch(BASE_URL);
      const data: Habit[] = await res.json();
      setHabits(data);
    } catch (err) {
      console.error(err);
    }
  };

  // POST create habit
  const createHabit = async () => {
    try {
      await fetch(BASE_URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ habitName, type }),
      });
      setHabitName("");
      setType("");
      fetchHabits();
    } catch (err) {
      console.error(err);
    }
  };

  // GET single habit
  const fetchHabitById = async () => {
    try {
      const res = await fetch(`${BASE_URL}/${habitId}`);
      const data: Habit = await res.json();
      setSingleHabit(data);
    } catch (err) {
      console.error(err);
    }
  };

  // DELETE habit
  const deleteHabit = async (id: number) => {
    try {
      await fetch(`${BASE_URL}/${id}`, {
        method: "DELETE",
      });
      fetchHabits();
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchHabits();
  }, []);

  return (
    <div>
      <h1>Habit Tracker Test</h1>

      <h2>Create Habit</h2>
      <input
        placeholder="Habit Name"
        value={habitName}
        onChange={(e) => setHabitName(e.target.value)}
      />
      <input
        placeholder="Type"
        value={type}
        onChange={(e) => setType(e.target.value)}
      />
      <button onClick={createHabit}>Create</button>

      <h2>All Habits</h2>
      <button onClick={fetchHabits}>Refresh</button>
      <ul>
        {habits.map((habit) => (
          <li key={habit.id}>
            {habit.habitName} - {habit.type}
            <button onClick={() => deleteHabit(habit.id)}>Delete</button>
          </li>
        ))}
      </ul>

      <h2>Get Habit By ID</h2>
      <input
        placeholder="Habit ID"
        value={habitId}
        onChange={(e) => setHabitId(e.target.value)}
      />
      <button onClick={fetchHabitById}>Fetch</button>

      {singleHabit && (
        <div>
          <h3>Habit Details</h3>
          <p>ID: {singleHabit.id}</p>
          <p>Name: {singleHabit.habitName}</p>
          <p>Type: {singleHabit.type}</p>
        </div>
      )}
    </div>
  );
}
