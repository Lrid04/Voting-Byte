import Navbar from '../ui/navbar'
 
export default function Layout({
    children,
  }: Readonly<{
    children: React.ReactNode;
  }>){
  return (
    <div>
      <Navbar />
      <main className="text-white ml-40">{children}</main>
    </div>
  )
}